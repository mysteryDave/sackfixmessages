package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class NetworkCounterpartySystemStatusResponseMessage(networkStatusResponseTypeField:NetworkStatusResponseTypeField,
                                                          networkRequestIDField:Option[NetworkRequestIDField]=None,
                                                          networkResponseIDField:NetworkResponseIDField,
                                                          lastNetworkResponseIDField:Option[LastNetworkResponseIDField]=None,
                                                          compIDStatGrpComponent:CompIDStatGrpComponent) extends SfFixMessageBody("BD")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,networkStatusResponseTypeField)
    networkRequestIDField.foreach(fmt(b,_))
    fmt(b,networkResponseIDField)
    lastNetworkResponseIDField.foreach(fmt(b,_))
    fmt(b,compIDStatGrpComponent)
    b
  }

}
     
object NetworkCounterpartySystemStatusResponseMessage extends SfFixMessageDecoder {
  val MsgType="BD"
  val MsgName="NetworkCounterpartySystemStatusResponse"
             
  override val MandatoryFields = HashSet[Int](
    NetworkStatusResponseTypeField.TagId, NetworkResponseIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CompIDStatGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NetworkRequestIDField.TagId, LastNetworkResponseIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CompIDStatGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CompIDStatGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==NetworkStatusResponseTypeField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NetworkCounterpartySystemStatusResponseMessage(NetworkStatusResponseTypeField.decode(myFields.get(NetworkStatusResponseTypeField.TagId)).get,
        myFields.get(NetworkRequestIDField.TagId).flatMap(f=>NetworkRequestIDField.decode(f)),
        NetworkResponseIDField.decode(myFields.get(NetworkResponseIDField.TagId)).get,
        myFields.get(LastNetworkResponseIDField.TagId).flatMap(f=>LastNetworkResponseIDField.decode(f)),
        CompIDStatGrpComponent.decode(flds, startPos).get))
    } else None
  }

    
}
     