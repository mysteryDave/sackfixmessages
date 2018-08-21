package org.sackfix.fix42

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
case class TradingSessionStatusRequestMessage(tradSesReqIDField:TradSesReqIDField,
                                              tradingSessionIDField:Option[TradingSessionIDField]=None,
                                              tradSesMethodField:Option[TradSesMethodField]=None,
                                              tradSesModeField:Option[TradSesModeField]=None,
                                              subscriptionRequestTypeField:SubscriptionRequestTypeField) extends SfFixMessageBody("g")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradSesReqIDField)
    tradingSessionIDField.foreach(fmt(b,_))
    tradSesMethodField.foreach(fmt(b,_))
    tradSesModeField.foreach(fmt(b,_))
    fmt(b,subscriptionRequestTypeField)
    b
  }

}
     
object TradingSessionStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="g"
  val MsgName="TradingSessionStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    TradSesReqIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    TradingSessionIDField.TagId, TradSesMethodField.TagId, TradSesModeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradSesReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradingSessionStatusRequestMessage(TradSesReqIDField.decode(myFields.get(TradSesReqIDField.TagId)).get,
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradSesMethodField.TagId).flatMap(f=>TradSesMethodField.decode(f)),
        myFields.get(TradSesModeField.TagId).flatMap(f=>TradSesModeField.decode(f)),
        SubscriptionRequestTypeField.decode(myFields.get(SubscriptionRequestTypeField.TagId)).get))
    } else None
  }

    
}
     