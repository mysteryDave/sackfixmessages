package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class QuoteRequestMessage(quoteReqIDField:QuoteReqIDField,
                               rFQReqIDField:Option[RFQReqIDField]=None,
                               clOrdIDField:Option[ClOrdIDField]=None,
                               orderCapacityField:Option[OrderCapacityField]=None,
                               noRelatedSymField:NoRelatedSymField,
                               relatedSymGroups: List[RelatedSymGroup],
                               textField:Option[TextField]=None,
                               encodedTextLenField:Option[EncodedTextLenField]=None,
                               encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("R")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRelatedSymField.value != relatedSymGroups.size)
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.value, relatedSymGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,quoteReqIDField)
    rFQReqIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    fmt(b,noRelatedSymField)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteRequestMessage extends SfFixMessageDecoder {
  val MsgType="R"
  val MsgName="QuoteRequest"
             
  override val MandatoryFields = HashSet[Int](
    QuoteReqIDField.TagId, NoRelatedSymField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RelatedSymGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RFQReqIDField.TagId, ClOrdIDField.TagId, OrderCapacityField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RelatedSymGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RelatedSymGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRelatedSymField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteRequestMessage(QuoteReqIDField.decode(myFields.get(QuoteReqIDField.TagId)).get,
        myFields.get(RFQReqIDField.TagId).flatMap(f=>RFQReqIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
        NoRelatedSymField.decode(myFields.get(NoRelatedSymField.TagId)).get,
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)).get else List.empty,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     