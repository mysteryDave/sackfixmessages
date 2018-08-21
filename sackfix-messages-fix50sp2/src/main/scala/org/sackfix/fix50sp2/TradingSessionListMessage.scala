package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class TradingSessionListMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                     tradSesReqIDField:Option[TradSesReqIDField]=None,
                                     trdSessLstGrpComponent:TrdSessLstGrpComponent) extends SfFixMessageBody("BJ")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    tradSesReqIDField.foreach(fmt(b,_))
    fmt(b,trdSessLstGrpComponent)
    b
  }

}
     
object TradingSessionListMessage extends SfFixMessageDecoder {
  val MsgType="BJ"
  val MsgName="TradingSessionList"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || TrdSessLstGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TradSesReqIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || TrdSessLstGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || TrdSessLstGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradingSessionListMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(TradSesReqIDField.TagId).flatMap(f=>TradSesReqIDField.decode(f)),
        TrdSessLstGrpComponent.decode(flds, startPos).get))
    } else None
  }

    
}
     